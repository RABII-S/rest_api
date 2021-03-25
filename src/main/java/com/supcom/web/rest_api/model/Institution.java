package com.supcom.web.rest_api.model;
import javax.persistence.Column; import javax.persistence.Entity;
import javax.persistence.GeneratedValue; import javax.persistence.GenerationType; import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "inst")
public class Institution {
    private long Id;
    private String Name;
    private String Service;
    private long  Line;
    private long Current;
        // Constructor
        public Institution() {
        }
        public Institution(final String Name,final String Service, final long Line, final long Current) {
            this.Name =Name;
            this.Line=Line;
            this.Service=Service;
            this.Current = Current;
        }
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
            return Id;
        }
        public void setId(final long id) {
            this.Id = id;
        }
        @Column(name = "Name", nullable = false)
        public String getName() {
            return Name; }
        public void setName(final String firstName) {
            this.Name = firstName;
        }
        @Column(name = "Line", nullable = false)
        public long getLine() {
            return Line;
        }
        public void setLine(final long Line) {
            this.Line = Line;
        }
        
        @Column(name = "Current", nullable = false)
        public long getCurrent() {
            return Current;
        }
        public void setCurrent(final long Line) {
            this.Current = Line;
        }
         @Column(name = "Service", nullable = false)
         public String getService() {
                return Service;
            }
         public void setService(final String Service) {
                this.Service = Service;
        }
    
}
