unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    eX: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    eY: TEdit;
    eZ: TEdit;
    lU: TLabel;
    Button1: TButton;
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var
  // Объявление переменных для хранени введенных данных
  x, y, z : Integer;
  // Объявление переменной для результата рассчета
  u: Double;
begin
  // Инициализация переменных введенными данными
  x := StrToInt(eX.Text);
  y := StrToInt(eY.Text);
  z := StrToInt(eZ.Text);

  // Получение резульатата рассчета
  u := exp(ln(x + y + z) * 3) - sqr(x - y +z) + sqrt(abs(x + y + z));

  lU.Caption := 'U = ' + FloatToStr(u);

end;

end.
