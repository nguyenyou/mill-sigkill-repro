package generated

final case class Data159(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data159 = copy(name = name.toUpperCase)
  def scale(k: Double): Data159 = copy(value = value * k)
  def addTag(t: String): Data159 = copy(tags = t :: tags)
  def put(k: String, v: String): Data159 = copy(meta = meta.updated(k, v))
  def merge(other: Data159): Data159 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data159 {
  given Ordering[Data159] = Ordering.by(_.id)
  def empty: Data159 = Data159(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data159 =
    Data159(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data159] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
