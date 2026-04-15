package generated

final case class Data390(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data390 = copy(name = name.toUpperCase)
  def scale(k: Double): Data390 = copy(value = value * k)
  def addTag(t: String): Data390 = copy(tags = t :: tags)
  def put(k: String, v: String): Data390 = copy(meta = meta.updated(k, v))
  def merge(other: Data390): Data390 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data390 {
  given Ordering[Data390] = Ordering.by(_.id)
  def empty: Data390 = Data390(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data390 =
    Data390(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data390] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
