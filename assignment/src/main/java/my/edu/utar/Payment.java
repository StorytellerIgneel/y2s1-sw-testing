package my.edu.utar;

public class Payment {
    double totalTicketPrice;
    String paymentStatus;
    

    public String makePayment(int bookingID, double totalTicketPrice, String userEmail){
        Email email = new Email();

        String paymentStatus;
        
        /**this method will call the third-party payment getaway to
        proceed with payment (either credit card or online payment
        methods) and will return the payment status if it is successful or
        not successful*/
        /**if the payment is successful, this method then will call the
        following methods:*/ 

        
        return paymentStatus;
    }

}
