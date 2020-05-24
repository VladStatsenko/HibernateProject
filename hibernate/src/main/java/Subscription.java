import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private Id id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",updatable = false, insertable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",updatable = false, insertable = false)
    private Student student;

    public Subscription() {
    }

    public Subscription(Id id, Student student, Course course, Date subscriptionDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.subscriptionDate = subscriptionDate;

    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    @Embeddable
    public static class Id implements Serializable {


        @Column(name = "student_id")
        private int studentId;


        @Column(name = "course_id")
        private int courseId;

        public Id() {
        }

        public Id(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }
    }
