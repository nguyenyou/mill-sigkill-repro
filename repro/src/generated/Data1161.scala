package generated

final case class Data1161(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1161 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1161 = copy(value = value * k)
  def addTag(t: String): Data1161 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1161 = copy(meta = meta.updated(k, v))
  def merge(other: Data1161): Data1161 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1161 {
  given Ordering[Data1161] = Ordering.by(_.id)
  def empty: Data1161 = Data1161(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1161 =
    Data1161(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1161] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
