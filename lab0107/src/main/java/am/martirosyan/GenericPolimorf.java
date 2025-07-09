package am.martirosyan;

public class GenericPolimorf<T> {
    private T object;

    public GenericPolimorf(T object) {
        this.object = object;
    }

    public void callMethod() {
        if (object instanceof Parent) {
            ((Parent) object).someMethod();
        } else {
            System.out.println("Object does not implement Parent interface");
        }
    }

    public static void main(String[] args) {
        GenericPolimorf<Heir> heirGeneric = new GenericPolimorf<>(new Heir());
        heirGeneric.callMethod();

        GenericPolimorf<String> heirTwoGeneric = new GenericPolimorf<>(new String());
        heirTwoGeneric.callMethod();
    }
}
