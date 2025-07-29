# UserPublisher

Este projeto é responsável pela criação e registro de novos usuários. Utiliza o banco de dados Realm para persistência local, garantindo que os dados do usuário  sejam armazenados corretamente. Após o registro,
uma mensagem contendo as informações relevantes do usuário é publicada para consumo externo.

## Funcionalidades

- Criar e salvar um usuário.
- Gerar e publicar uma mensagem com dados do usuário.
- Servir como origem de dados para o consumidor de e-mails.
