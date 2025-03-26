package br.edu.ifpi.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoEmail {
// Injeta automaticamente o JavaMailSender, responsável por enviar e-mails
    @Autowired
    private JavaMailSender mailSender;//Método para enviar uma notificação por e-mail quando um livro é emprestado.

    public void notificarEmprestimo(String destinatario, String titulo){
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("marquesmanda2025@gmail.com");
        mensagem.setTo(destinatario); //define quem ira receber esse email
        mensagem.setSubject("NOTIFICAÇÃO DE EMPRÉSTIMO, PRINCESA -  BIBLIOTECA CENTRAL");//define o assunto do email
        mensagem.setText("\nO livro "+ titulo +"  foi emprestado para a diva " + destinatario + "!");
        
        mailSender.send(mensagem);// envia a mensagem 
    } 

    public void notificarDevolucao(String destinatario, String titulo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("marquesmanda2025@gmail.com");
        mensagem.setTo(destinatario);
        mensagem.setSubject("NOTIFICAÇÃO DE DEVOLUÇÃO, PRINCESA - BIBLIOTECA CENTRAL");
        mensagem.setText("\nO livro " + titulo + " foi devolvido pela diva " + destinatario + "!");
    
        mailSender.send(mensagem);
    }}