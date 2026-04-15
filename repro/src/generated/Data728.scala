package generated

final case class Data728(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data728 = copy(name = name.toUpperCase)
  def scale(k: Double): Data728 = copy(value = value * k)
  def addTag(t: String): Data728 = copy(tags = t :: tags)
  def put(k: String, v: String): Data728 = copy(meta = meta.updated(k, v))
  def merge(other: Data728): Data728 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data728 {
  given Ordering[Data728] = Ordering.by(_.id)
  def empty: Data728 = Data728(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data728 =
    Data728(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data728] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
