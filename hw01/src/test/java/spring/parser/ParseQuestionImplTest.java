package spring.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;
import ru.otus.spring.parser.CsvParserImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParseQuestionImplTest {
    private CsvParserImpl parserQuestion;
    private List<String[]> question;
    private List<Question> questions;

    @BeforeEach
    void setUp() {
        question = new ArrayList<>();
        questions = new ArrayList<>();
        question.add(new String[]{"A", "Which of the following is an example of physics at work in a smart phone?",
                " A - All of these answers",
                " B - Equations used in GPS",
                " C - Electricity used in circuit boards",
                " D - Electromagnets used in speakers"});
        Question question = new Question("A",
                "Which of the following is an example of physics at work in a smart phone?",
                getAnswerList());
        questions.add(question);
    }

    @Test
    void shouldListQuestionFromArray() {
        parserQuestion = new CsvParserImpl();

        List<Question> parsingResult = parserQuestion.parse(question);

        List<Question> expected = questions;

        assertThat(parsingResult).usingFieldByFieldElementComparator().containsExactlyInAnyOrderElementsOf(expected);
    }

    private static List<String> getAnswerList() {
        List<String> result = new ArrayList<>(4);

        result.add(" A - All of these answers");
        result.add(" B - Equations used in GPS");
        result.add(" C - Electricity used in circuit boards");
        result.add(" D - Electromagnets used in speakers");

        return result;
    }
}