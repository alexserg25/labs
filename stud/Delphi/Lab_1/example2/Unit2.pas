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
  // ���������� ���������� ��� ������ �� ������� � ������.
  F: TextFile;
  S: String ;

implementation

{$R *.dfm}

// ����� ��������� ������� ������� ������ Button2
procedure TForm1.Button2Click(Sender: TObject);
begin
  // ������� �����
  Close;
end;

// ����� ��������� ������� ������� ������ Button1
procedure TForm1.Button1Click(Sender: TObject);
begin
  // ���������� S ��������� �������� �������� ����� ������ Edit1
  S := Edit1.Text;
  // ��������� �������� �������� ����� ������ Edit1
  Edit1.Text := '';
end;

// ��������� ������� �������� ����.
procedure TForm1.FormCreate(Sender: TObject);
begin
  // ��������������� �������� ������
  Button1.Caption := '���������';
end;

// ������ �������������
INITIALIZATION
  // ������������� ��������� F
  AssignFile(F,'File1.txt');
  // �������� ����� F �� ����������
  Rewrite(F);

  // ������ ����������
FINALIZATION
  // ������ ������ S � ���� F
  Writeln(F,S);
  // �������� ����� F
  CloseFile(F);

end.
