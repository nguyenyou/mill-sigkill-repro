package generated

final case class Data1055(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1055 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1055 = copy(value = value * k)
  def addTag(t: String): Data1055 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1055 = copy(meta = meta.updated(k, v))
  def merge(other: Data1055): Data1055 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1055 {
  given Ordering[Data1055] = Ordering.by(_.id)
  def empty: Data1055 = Data1055(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1055 =
    Data1055(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1055] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
