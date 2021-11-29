package fr.gamedev.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.service.ResponseService;

/**
 * @author djer1
 */
@RestController
public final class ResponseController {
    /**
     * Service gérant les requêtes concernant les réponses.
     */
    @Autowired
    private ResponseService responseService;

    /**
     * Gets a response of an user's answer.
     *
     * @param questionId the question id.
     * @param answer     the user answer.
     * @param userId     the user id.
     * @return the response of the user's answer.
     */
    @GetMapping("/response")
    public String answer(@RequestParam
    final long questionId, @RequestParam
    final Boolean answer, @RequestParam
    final long userId) {

        String response = responseService.handleAnswer(questionId, answer, userId);
        return response;
    }

}
