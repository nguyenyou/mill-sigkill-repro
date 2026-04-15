package generated

final case class Data1279(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1279 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1279 = copy(value = value * k)
  def addTag(t: String): Data1279 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1279 = copy(meta = meta.updated(k, v))
  def merge(other: Data1279): Data1279 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1279 {
  given Ordering[Data1279] = Ordering.by(_.id)
  def empty: Data1279 = Data1279(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1279 =
    Data1279(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1279] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
