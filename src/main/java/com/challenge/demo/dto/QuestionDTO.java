package com.challenge.demo.dto;

import com.challenge.demo.model.Question;
import com.challenge.demo.model.Site;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDTO {

	private Long questionId;

	private Long siteId;

	private String question;

	private String questionType;



    private Date createdAt;

	private Date updatedAt;

	public static QuestionDTO build(Question question) {
		final QuestionDTO obj = new QuestionDTO();
		obj.setSiteId(question.getSite().getSiteId());
		obj.setQuestionId(question.getQuestionId());
		obj.setQuestion(question.getQuestion());
		obj.setQuestionType(question.getQuestionType());
		obj.setUpdatedAt(question.getUpdatedAt());
		obj.setCreatedAt(question.getCreatedAt());

		return obj;
	}

	public static List<QuestionDTO> build(List<Question> questions) {
		final List<QuestionDTO> ret = new ArrayList<>();

		for (Question question : questions) {
			ret.add(build(question));
		}

		return ret;
	}

	public static Question createQuestion(final QuestionDTO incomingQuestion, final Site site) {
		final Question newQ = new Question();
		newQ.setSite(site);
		newQ.setQuestion(incomingQuestion.getQuestion());
		newQ.setQuestionType(incomingQuestion.getQuestionType());

		return newQ;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(final Long siteId) {
		this.siteId = siteId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(final String question) {
		this.question = question;
	}

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(final Long questionId) {
		this.questionId = questionId;
	}
}
