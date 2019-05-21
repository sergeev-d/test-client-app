package com.assessments.portal.web.domain.assessment;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "assessment")
public class AssessmentDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "comment", length = 200)
    private String comment;

    @Column(name = "company_type_id", nullable = false)
    private Integer companyTypeId;

    @Column(name = "industry_id", nullable = false)
    private Integer industryId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @Lob
    @Column(name = "context")
    private Object context;

    public static AssessmentDAO create(Long id, String name, String description, String status, String comment, Integer companyTypeId,
                                       Integer industryId, Long userId, Date createdDate, Date updatedDate) {
        AssessmentDAO assessmentDAO = new AssessmentDAO();
        assessmentDAO.id = id;
        assessmentDAO.name = name;
        assessmentDAO.description = description;
        assessmentDAO.status = status;
        assessmentDAO.comment = comment;
        assessmentDAO.companyTypeId = companyTypeId;
        assessmentDAO.industryId = industryId;
        assessmentDAO.userId = userId;
        assessmentDAO.createdDate = createdDate;
        assessmentDAO.updatedDate = updatedDate;

        return assessmentDAO;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public Object getContext() {
        return context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentDAO that = (AssessmentDAO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userId, that.userId);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userId);
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", name=" + name +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", companyTypeId=" + companyTypeId +
                ", industryId=" + industryId +
                ", userId='" + userId + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", context=" + context +
                '}';
    }
}
