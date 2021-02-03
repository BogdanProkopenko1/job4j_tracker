package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        for (Account rsl : users.get(user)) {
     //       ArrayList<Account> result = new ArrayList<>();
       //     result.add(rsl);
            String check = rsl.getRequisite();
            if (!check.contains(account.getRequisite())) {
         //       Account add = new Account(account.getRequisite(), account.getBalance());
           //     result.add(add);
             //   users.put(user, result);
             //   users.put(user, users.get(user).add(account));
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().contains(passport)) {
                rsl = user;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        for (Account account : users.get(findByPassport(passport))) {
            if (account.getRequisite().contains(requisite)) {
                rsl = account;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account transfer = new Account();
        User user = findByPassport(destPassport);
        for (Account account1 : users.get(findByPassport(destPassport))) {
            transfer = account1.getRequisite().contains(destRequisite) ? account1 : null;
        }
        for (Account account2 : users.get(findByPassport(srcPassport))) {
            if (account2.getRequisite().contains(srcRequisite)) {
                double balance = transfer.getBalance() + amount;
                transfer.setBalance(balance);
            }
        }
        boolean rsl = false;
        return rsl;
    }
}