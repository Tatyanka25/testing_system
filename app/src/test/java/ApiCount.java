import com.google.gson.annotations.SerializedName;

public class ApiCount {

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("category_question_count")
    private Category categoryQuestionCount;

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }

    public int getCategoryId(){
        return categoryId;
    }

    public void setCategory(Category categoryQuestionCount){
        this.categoryQuestionCount = categoryQuestionCount;
    }

    public Category getCategoryQuestionCount(){
        return categoryQuestionCount;
    }
}