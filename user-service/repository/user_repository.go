package repository

import (
	"errors"
	"user-service/presentation/web-schemas"
	"user-service/repository/dto-schemas"

	"gorm.io/gorm"
)

type UserRepository interface {
	Create(user web_schemas.NewUserIn) error
	GetByUsername(username string) (dto_schemas.UserDtoSchema, error)
	Update(user web_schemas.NewUserIn) error
}

type GORMUserRepository struct {
	db *gorm.DB
}

func NewGORMUserRepository(db *gorm.DB) *GORMUserRepository {
	return &GORMUserRepository{
		db: db,
	}
}

func (r *GORMUserRepository) Create(user web_schemas.NewUserIn) error {
	var existingUser dto_schemas.UserDtoSchema
	if err := r.db.Where("username = ?", user.Username).First(&existingUser).Error; err == nil {
		return errors.New("user already exists")
	}

	newUser := dto_schemas.UserDtoSchema{
		Username: user.Username,
		Password: user.Password,
	}

	return r.db.Create(&newUser).Error
}

func (r *GORMUserRepository) GetByUsername(username string) (dto_schemas.UserDtoSchema, error) {
	var user dto_schemas.UserDtoSchema
	err := r.db.Where("username = ?", username).First(&user).Error
	if err != nil {
		return dto_schemas.UserDtoSchema{}, errors.New("user not found")
	}
	return user, nil
}

func (r *GORMUserRepository) Update(user web_schemas.NewUserIn) error {
	var existingUser dto_schemas.UserDtoSchema
	if err := r.db.Where("username = ?", user.Username).First(&existingUser).Error; err != nil {
		return errors.New("user not found")
	}
	existingUser.Password = user.Password
	return r.db.Save(&existingUser).Error
}
