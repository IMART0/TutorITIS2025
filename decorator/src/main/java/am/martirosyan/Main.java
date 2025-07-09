package am.martirosyan;

import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        YooMoneyPaymentCheckService service = new YooMoneyPaymentCheckService();
        System.out.println(generatePaymentLink(123L, 456L));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment label to check:");
        String label = scanner.nextLine();
        service.isPaymentSuccessful("event-123-ticket-456", 2);
    }

    public static String generatePaymentLink(Long ticketId, Long eventId) {

        String label = String.format("event-%s-ticket-%s", eventId, ticketId);
        String targets = String.format("Оплата билета %s на мероприятие %s", ticketId, eventId);


        URI uri = UriComponentsBuilder
                .fromUriString("https://yoomoney.ru/quickpay/confirm.xml")
                .queryParam("receiver", "4100117529100587")
                .queryParam("quickpay-form", "donate")
                .queryParam("paymentType", "AC")
                .queryParam("targets", targets)
                .queryParam("sum", BigDecimal.valueOf(2))
                .queryParam("label", label)
                .queryParam("comment", "Спасибо за покупку")
                .queryParam("successURL", "SUCCESS_URL")
                .build(false)
                .encode(StandardCharsets.UTF_8)
                .toUri();

        return uri.toString();
    }
}
