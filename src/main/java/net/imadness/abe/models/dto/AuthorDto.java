package net.imadness.abe.models.dto;

import net.imadness.abe.models.Author;

import javax.validation.constraints.NotNull;

// TODO определиться уже с конструкторами
public class AuthorDto {
    // здесь не совсем понятно, что именно мы хотим здесь видеть
    // на уровне сервиса можно искать авторов по id или же по nickname (у второго очевидный минус)
    // с другой стороны получается, что особо смысла в этом dto и нету
    private Long id;
    @NotNull
    private String nickname;
    
    public AuthorDto() {
    }
    
    /**
     * Конструктор для уже существующего пользователя
     * @param id
     * @param nickname
     */
    public AuthorDto(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
    
    /**
     * Создаёт на основе инкапсулированных данных соответствющий доменный объект {@link Author}
     * @return объект сущности Author
     */
    public Author createAuthor() {
        Author result = new Author();
        result.setId(this.id);
        result.setNickname(this.nickname);
        return result;
    }
    
    /**
     * Конструктор для объекта AuthorDto без ID
     * @param nickname
     */
    public AuthorDto(String nickname) {
        this.nickname = nickname;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      AuthorDto other = (AuthorDto) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (nickname == null) {
        if (other.nickname != null)
          return false;
      } else if (!nickname.equals(other.nickname))
        return false;
      return true;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}