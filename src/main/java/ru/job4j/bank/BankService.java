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
        boolean add = true;
        if (!users.get(user).equals(null)) {
            for (Account rsl : users.get(user)) {
                String check = rsl.getRequisite();
                if (check.equals(account.getRequisite())) {
                    add = false;
                    break;
                }
            }
            if (add) {
                List<Account> put = new ArrayList<>();
                for (Account accounts : users.get(user)) {
                    put.add(accounts);
                }
                put.add(account);
                users.put(user, put);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        if (users.get(findByPassport(passport)) != null) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        } else {
            return null;
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account transfer = new Account();
        boolean rsl = false;
        User dest = findByPassport(destPassport);
        User src = findByPassport(srcPassport);
        if (dest != null) {
            for (Account accountDest : users.get(dest)) {
                if (accountDest.getRequisite().contains(destRequisite)) {
                    transfer = accountDest;
                    break;
                }
            }
        }
        if (src != null) {
            for (Account accountSrc : users.get(src)) {
                if (accountSrc.getRequisite().contains(srcRequisite)) {
                    if (amount >= accountSrc.getBalance()) {
                        double balanceNow = transfer.getBalance() + amount;
                        transfer.setBalance(balanceNow);
                        rsl = true;
                        break;
                    } else {
                        System.out.println("The transferred amount exceeds the account balance.");
                        rsl = false;
                        break;
                    }
                }
            }
        }
        return rsl;
    }
}