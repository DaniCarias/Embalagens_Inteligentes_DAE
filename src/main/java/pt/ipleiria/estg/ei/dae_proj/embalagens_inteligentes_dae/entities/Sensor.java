package pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.entities;

import jakarta.enterprise.inject.Typed;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.hibernate.mapping.Value;
import org.hibernate.usertype.UserType;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

/**
 * This class represents a specific sensor of a specific package. Not just the sensor type.
 */
@Entity
@NamedQueries({
        @NamedQuery(name= "getAllSensors", query= "SELECT s FROM Sensor s"),
        @NamedQuery(name= "getSensorsByManufacturer", query="SELECT s FROM Sensor s" +
                " JOIN Package pck ON pck.id = s._package.id " +
                " JOIN Product p ON p.id = pck.product.id " +
                " WHERE p.manufacturer.username LIKE :username"),
})
@Table(
        name="sensors",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id"})
)
@SQLDelete(sql="UPDATE sensors SET deleted = true WHERE id = ? AND version = ?")
@Where(clause = "deleted = false")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "sensor")
    private List<SensorReading> readings;

    @ManyToOne // because this is the sensor of a specific package
    private Package _package;

    @OneToMany(mappedBy = "sensor")
    private List<QualityConstraint> controlledConstraints; // the quality constraints this sensor controls

    @Version
    private int version;

    private Date deleted_at;

    private boolean deleted = Boolean.FALSE;


    public Sensor() {
        this.readings = new LinkedList<>();
    }
    public Sensor(String name, Package _package){
        this.name = name;
        this._package = _package;
        this.readings = new LinkedList<>();
        this.controlledConstraints = new LinkedList<>();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setReadings(List<SensorReading> readings) {
        this.readings = readings;
    }
    public Package get_package() {
        return _package;
    }
    public void set_package(Package _package) {
        this._package = _package;
    }
    public void setControlledConstraints(List<QualityConstraint> controlledConstraints) {
        this.controlledConstraints = controlledConstraints;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<SensorReading> getReadings() {
        return readings;
    }
    public void addReading(SensorReading reading) {
        if(!readings.contains(reading)) {
            this.readings.add(reading);
        }
    }
    public Package getPackage() {
        return this._package;
    }
    public void removeReading(SensorReading reading) {
        if(readings.contains(reading)) {
            this.readings.remove(reading);
        }
    }
    public List<QualityConstraint> getControlledConstraints() {
        return controlledConstraints;
    }
    public void addControlledConstraint(QualityConstraint constraint) {
        this.controlledConstraints.add(constraint);
    }
    public Date getDeleted_at() {
        return deleted_at;
    }
    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
