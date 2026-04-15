package generated

final case class Data1044(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1044 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1044 = copy(value = value * k)
  def addTag(t: String): Data1044 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1044 = copy(meta = meta.updated(k, v))
  def merge(other: Data1044): Data1044 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1044 {
  given Ordering[Data1044] = Ordering.by(_.id)
  def empty: Data1044 = Data1044(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1044 =
    Data1044(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1044] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
