package generated

final case class Data565(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data565 = copy(name = name.toUpperCase)
  def scale(k: Double): Data565 = copy(value = value * k)
  def addTag(t: String): Data565 = copy(tags = t :: tags)
  def put(k: String, v: String): Data565 = copy(meta = meta.updated(k, v))
  def merge(other: Data565): Data565 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data565 {
  given Ordering[Data565] = Ordering.by(_.id)
  def empty: Data565 = Data565(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data565 =
    Data565(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data565] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
