package com.example.back_end.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class IssueTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issueIdPk;
    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String title;

    @NotNull
    @Column(columnDefinition = "varchar (40)")
    private String publisher;

    @NotNull
    @Column(columnDefinition = "varchar (100)")
    private String url;

    private LocalDate issueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resourceIdPk")
    private ResourceTb resourceIdPk;

    @Builder
    public IssueTb(String title,
                      String publisher,
                      String url,
                      LocalDate issueDate,
                      ResourceTb resourceIdPk
    ) {
        this.title = title;
        this.publisher = publisher;
        this.url = url;
        this.issueDate = issueDate;
        this.resourceIdPk = resourceIdPk;
    }
}
