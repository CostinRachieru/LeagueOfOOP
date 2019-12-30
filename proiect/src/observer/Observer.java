package observer;

import hero.Coordinates;

public interface Observer {
    void update(String name, Coordinates location);
    void update(String killer, String killed);
    void update(String angelName, String heroeName, String action);
    void update(String name, int level);
    void update(String name);
    void updateAngelKill(String killed);
}
