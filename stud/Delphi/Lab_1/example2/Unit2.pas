unit Unit2;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    Button1: TButton;
    Button2: TButton;
    Edit1: TEdit;
    Label1: TLabel;
    procedure Button2Click(Sender: TObject);
    procedure Button1Click(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  // Объявление переменных для работы со строкой и файлом.
  F: TextFile;
  S: String ;

implementation

{$R *.dfm}

// Метод обработки события нажатия кнопки Button2
procedure TForm1.Button2Click(Sender: TObject);
begin
  // Закрыть форму
  Close;
end;

// Метод обработки события нажатия кнопки Button1
procedure TForm1.Button1Click(Sender: TObject);
begin
  // переменной S присвоить значение элемента ввода текста Edit1
  S := Edit1.Text;
  // Обнуление значение элемента ввода текста Edit1
  Edit1.Text := '';
end;

// Обработка события создания окна.
procedure TForm1.FormCreate(Sender: TObject);
begin
  // Переопределение названия кнопки
  Button1.Caption := 'Выполнить';
end;

// Секция инициализации
INITIALIZATION
  // Инициализация переменно F
  AssignFile(F,'File1.txt');
  // Открытие файла F на перезапись
  Rewrite(F);

  // Секция завершения
FINALIZATION
  // Запись строки S в файл F
  Writeln(F,S);
  // закрытие файла F
  CloseFile(F);

end.
