/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import venttigame.domain.Player;

/**
 *
 * @author marye
 */
public class FilePlayerDao implements PlayerDao {

    private List<Player> users;
    private String file;

    public FilePlayerDao(String file) throws Exception {
        users = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Player u = new Player(parts[0], parts[1]);
                users.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Player user : users) {
                writer.write(user.getUsername() + ";" + user.getName() + "\n");
            }
        }
    }

    @Override
    public List<Player> getAll() {
        return users;
    }

    @Override
    public Player findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername()
                .equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Player create(Player user) throws Exception {
        users.add(user);
        save();
        return user;
    }
}
