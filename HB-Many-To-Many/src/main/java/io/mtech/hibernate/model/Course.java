package io.mtech.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
	        CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
	        CascadeType.MERGE,
	        CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "course_student",
	           joinColumns = @JoinColumn(name = "course_id"),
	           inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	public Course() {
	}

	public Course(String title) {
		this.title = title; 
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// Add a convenience method review
	public void addReview(Review review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
	}

	// Add a convenience method for student
	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + this.id + ", title=" + this.title + "]";
	}

}
