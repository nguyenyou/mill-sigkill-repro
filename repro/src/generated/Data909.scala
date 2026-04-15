package generated

final case class Data909(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data909 = copy(name = name.toUpperCase)
  def scale(k: Double): Data909 = copy(value = value * k)
  def addTag(t: String): Data909 = copy(tags = t :: tags)
  def put(k: String, v: String): Data909 = copy(meta = meta.updated(k, v))
  def merge(other: Data909): Data909 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data909 {
  given Ordering[Data909] = Ordering.by(_.id)
  def empty: Data909 = Data909(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data909 =
    Data909(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data909] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
