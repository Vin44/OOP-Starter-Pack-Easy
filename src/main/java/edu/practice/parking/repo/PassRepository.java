package edu.practice.parking.repo;
import edu.practice.parking.model.*;import org.springframework.stereotype.Repository;
import java.util.*;import java.util.concurrent.ConcurrentHashMap;
@Repository public class PassRepository {
 private final Map<Long,ParkingPass> passes=new ConcurrentHashMap<>();
 public PassRepository(){
  passes.put(1L,new HourlyPass(1,"CAR-101",250));
  // TODO after Task 2: add new WeekendPass(2,"VAN-202",800).
 }
 public Collection<ParkingPass> all(){return List.copyOf(passes.values());}
 public ParkingPass get(long id){return passes.get(id);}
 public boolean contains(long id){return passes.containsKey(id);}
 public void save(ParkingPass pass){passes.put(pass.getId(),pass);}
}
