package com.group.testtask.data;

import com.group.testtask.data.Base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Degree extends Base {

    @Enumerated(value = EnumType.STRING)
    private DegreeEnum degreeEnum;

    @OneToMany(mappedBy = "degree")
    private List<Lector> list = new ArrayList<>();

    public Degree(DegreeEnum degreeEnum) {
        this.degreeEnum = degreeEnum;
    }

    public Degree(Long id, DegreeEnum degreeEnum) {
        super(id);
        this.degreeEnum = degreeEnum;
    }
}