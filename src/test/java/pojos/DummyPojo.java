package pojos;

public class DummyPojo {

    private  String  status;
    private Data data;
    private String message ;

    //2)


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DummyPojo(){

    }

    public DummyPojo(String status, Data data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
//3)to string
    @Override
    public String toString() {
        return "DummyPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}



