package generated

final case class Data839(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data839 = copy(name = name.toUpperCase)
  def scale(k: Double): Data839 = copy(value = value * k)
  def addTag(t: String): Data839 = copy(tags = t :: tags)
  def put(k: String, v: String): Data839 = copy(meta = meta.updated(k, v))
  def merge(other: Data839): Data839 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data839 {
  given Ordering[Data839] = Ordering.by(_.id)
  def empty: Data839 = Data839(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data839 =
    Data839(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data839] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
