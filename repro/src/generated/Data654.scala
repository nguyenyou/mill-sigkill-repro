package generated

final case class Data654(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data654 = copy(name = name.toUpperCase)
  def scale(k: Double): Data654 = copy(value = value * k)
  def addTag(t: String): Data654 = copy(tags = t :: tags)
  def put(k: String, v: String): Data654 = copy(meta = meta.updated(k, v))
  def merge(other: Data654): Data654 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data654 {
  given Ordering[Data654] = Ordering.by(_.id)
  def empty: Data654 = Data654(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data654 =
    Data654(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data654] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
