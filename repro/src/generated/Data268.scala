package generated

final case class Data268(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data268 = copy(name = name.toUpperCase)
  def scale(k: Double): Data268 = copy(value = value * k)
  def addTag(t: String): Data268 = copy(tags = t :: tags)
  def put(k: String, v: String): Data268 = copy(meta = meta.updated(k, v))
  def merge(other: Data268): Data268 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data268 {
  given Ordering[Data268] = Ordering.by(_.id)
  def empty: Data268 = Data268(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data268 =
    Data268(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data268] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
