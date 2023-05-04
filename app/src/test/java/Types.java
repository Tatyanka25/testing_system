import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Types implements Serializable{

        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("question")
        @Expose
        private String question;
        @SerializedName("correct_answer")
        @Expose
        private String correctAnswer;
        @SerializedName("incorrect_answers")
        @Expose
        private List<String> incorrectAnswers = null;


        public Result (String category, String question, String correctAnswer, List<String> incorrectAnswers) {
            super();
            this.category = category;
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.incorrectAnswers = incorrectAnswers;
        }

        public String getCategory() {
            return category;
        }


        public String getQuestion() {
            return question;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public List<String> getIncorrectAnswers() {
            return incorrectAnswers;
        }

}
