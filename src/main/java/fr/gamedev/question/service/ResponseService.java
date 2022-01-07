package fr.gamedev.question.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.User;
import fr.gamedev.question.data.UserAnswer;
import fr.gamedev.question.repository.AnswerRepository;
import fr.gamedev.question.repository.UserAnswerRepository;
import fr.gamedev.question.repository.UserRepository;

@Service
public final class ResponseService {

    //TODO grp4 by DJE : JavaDoc : Il est possible d'écrirela JavaDoc sur une seul ligne lorsqu'il n'y a pas de paramètre (@author, @param,...)
    /** Amount of points per good answer.*/
    private final int points = 5;

    /** The User repository.*/
    @Autowired
    private UserRepository userRepository;

    /** The Answer repository. */
    @Autowired
    private AnswerRepository answerRepository;

    /** The UserAnswer repository. */
    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public String handleAnswer(final long questionId, final Boolean userAnswer, final long userId) {
        Optional<Answer> answer = answerRepository.findByQuestionId(questionId);

        if (answer.isEmpty()) {
            return "La question n'a pas été trouvée.";
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return "L'utilisateur n'a pas été trouvé.";
        }

        String response = "";

        //TODO grp4 by DJE : Besoin : vous ne vérifiez pas que la question à été posée à CETTE utilisateur.
        UserAnswer newUserAnswer = new UserAnswer();
        newUserAnswer.setAnswer(answer.get());
        newUserAnswer.setUser(user.get());

        if (userAnswer == answer.get().getCorrectAnswer()) {
            newUserAnswer.setPoints(points);
            response = "Bravo ! Vous avez trouvé !";
        } else {
            newUserAnswer.setPoints(0);
            response = "Oops ! Ce n'est pas correct.";
        }

        userAnswerRepository.save(newUserAnswer);

        return response;
    }

    private ResponseService() {

    }
}
