package generated

final case class Data556(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data556 = copy(name = name.toUpperCase)
  def scale(k: Double): Data556 = copy(value = value * k)
  def addTag(t: String): Data556 = copy(tags = t :: tags)
  def put(k: String, v: String): Data556 = copy(meta = meta.updated(k, v))
  def merge(other: Data556): Data556 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data556 {
  given Ordering[Data556] = Ordering.by(_.id)
  def empty: Data556 = Data556(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data556 =
    Data556(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data556] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
