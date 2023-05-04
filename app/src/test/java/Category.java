import com.google.gson.annotations.SerializedName;

public class Category{
    @SerializedName("Животные")
        private int totalAnimalsQuestion;

    @SerializedName("Люди")
    private int totalPeopleQuestion;

    @SerializedName("Рандом")
        private int totalRandomQuestion;


    public void setTotalAnimalsQuestion(int totalAnimalsQuestion){
        this.totalAnimalsQuestion= totalAnimalsQuestion;
        }

    public int getTotalAnimalsQuestion(){
        return totalAnimalsQuestion;
        }

    public void setTotalPeopleQuestion(int totalPeopleQuestion){
        this.totalPeopleQuestion = totalPeopleQuestion;
        }

    public int getTotalPeopleQuestion(){
        return totalPeopleQuestion;
        }

    public void setTotalRandomQuestion(int totalRandomQuestion){
        this.totalRandomQuestion = totalRandomQuestion;
        }

    public int getTotalRandomQuestion(){
        return totalRandomQuestion;
        }
}
