package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Этот класс описывает работу банковского сервиса
 * @author VYACHESLAV PORECHNEV
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы
     * с привязанным к ним счетам
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает один параметр: объект класса User
     * По умолчанию к этому user добавляем пустой список
     * С помощью метода Map.putIfAbsent
     * происходит проверка, что такого пользователя еще нет в системе
     * Если он есть, то новый не добавляется
     * @param user пользователь которого мы добавляем в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю
     * В начале ищем пользователя по паспорту через метод findByPassport
     * Затем если пользователь найден, проверяем что у него нет такого счета
     * и добавляем новый счет
     * @param passport паспорт который мы ищем
     * @param account счет который хотим добавить
     */
    public void addAccount(String passport, Account account) {
        User userAccount = findByPassport(passport);
        if (userAccount != null) {
            List<Account> userAccounts = users.get(userAccount);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * Происходит перебор всех элементов карты users
     * и сравнение ключей с переданным параметром
     * @param passport паспорт который мы ищем
     * @return возвращает номер паспорта, либо null если ничего не найдено
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * Ищем пользователя по паспорту через findByPassport
     * Получаем список счетов пользователя и находим нужный счет
     * @param passport паспорт по которому ищем пользователя
     * @param requisite счет пользователя который у него ищем
     * @return возвращает номер реквизитов, либо null
     * если такого пользователя нет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод перечисляет денежные средства с одного счета на другой
     * Ищем отправителя и получателя через метод findByRequisite
     * Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false.
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма перевода денежных средств
     * @return возвращает true если перевод выполнен,
     * либо false, если не существует одного из аккаунтов
     * и баланс отправителя меньше amount
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}