public class DataInputs {
    @org.testng.annotations.DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                {"Jovana", "Basaric", "ana@yahoo.com","33","9000","HR"}

        };
    }
}
