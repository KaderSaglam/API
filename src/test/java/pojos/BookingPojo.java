package pojos;
public class BookingPojo {
    /* "booking": {
         "firstname": "Ali",
                 "lastname": "Can",
                 "totalprice": 500,
                 "depositpaid": true,
                 "bookingdates": {
             "checkin": "2022-03-01",
                     "checkout": "2022-03-11"
         }
     }
 }
 */
    // 1- private degisken olustur
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesPojo bookingdatesPojo;
    //2- getter ve setter olusturulması
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public boolean isDepositpaid() {
        return depositpaid;
    }
    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public BookingDatesPojo getBookingdatesPojo() {
        return bookingdatesPojo;
    }
    public void setBookingdatesPojo(BookingDatesPojo bookingdatesPojo) {
        this.bookingdatesPojo = bookingdatesPojo;
    }
    //3 Parametreli ve Parametresiz constructor
    public BookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDatesPojo bookingdatesPojo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdatesPojo = bookingdatesPojo;
    }
    public BookingPojo() {
    }
    //4- toString()
    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdatesPojo=" + bookingdatesPojo +
                '}';
    }
}

