package spring.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.exception.ParserException;
import ru.otus.spring.parser.InputStreamParserImpl;
import ru.otus.spring.service.localization.LocalizationService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ParseInputStreamImplTest {
    @Mock
    private InputStreamParserImpl parserInputStream;
    @Mock
    private LocalizationService localizationService;

    private List<String[]> questions;

    @BeforeEach
    void setUp() {
        parserInputStream = new InputStreamParserImpl(localizationService);
        questions = new ArrayList<>();
        questions.add(new String[]{"A", "Which of the following is an example of physics at work in a smart phone?",
                " A - All of these answers",
                " B - Equations used in GPS",
                " C - Electricity used in circuit boards",
                " D - Electromagnets used in speakers"});
    }

    @Test
    void shouldThrowExceptionWhenInputStreamNull() {
        Exception exception = assertThrows(ParserException.class, () -> parserInputStream.parse(null));

        assertEquals(exception.getClass(), ParserException.class);
    }

    @Test
    void shouldReadFromResourceStream() throws ParserException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("the-basics-of-physics-test.csv");

        List<String[]> parsingResult = parserInputStream.parse(stream);

        List<String[]> expected = questions;

        assertThat(parsingResult).containsExactlyInAnyOrderElementsOf(expected);
    }
}