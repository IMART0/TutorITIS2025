package am.martirosyan;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


public class YooMoneyPaymentCheckService {

    private final String oauthToken = "399717BC72DE23BE14F3BD6D0CC9B06350107A92978E11397CE75E4CC622D3FBEEE0B34B08101159FECFF29B8EDC7CC0D70515FD4A3DAFC2C3CF3CAF5FC3CE3F";

    private static final String OPERATION_HISTORY_URL = "https://yoomoney.ru/api/operation-history";

    public boolean isPaymentSuccessful(String label, double expectedAmount) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(oauthToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("label", label);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                OPERATION_HISTORY_URL,
                HttpMethod.POST,
                request,
                Map.class
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            return false;
        }

        Map<String, Object> body = response.getBody();
        if (body == null || !body.containsKey("operations")) {
            return false;
        }

        var operations = (java.util.List<Map<String, Object>>) body.get("operations");

        // Ищем операцию со статусом success и нужной суммой
        for (Map<String, Object> op : operations) {
            String opStatus = (String) op.get("status");
            String opLabel = (String) op.get("label");
            Double opAmount = Double.valueOf(op.get("amount").toString());

            if ("success".equalsIgnoreCase(opStatus)
                    && label.equals(opLabel)
                    && Double.compare(opAmount, expectedAmount) == 0) {
                return true;
            }
        }

        return false;
    }
}
