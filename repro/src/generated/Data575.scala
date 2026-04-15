package generated

final case class Data575(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data575 = copy(name = name.toUpperCase)
  def scale(k: Double): Data575 = copy(value = value * k)
  def addTag(t: String): Data575 = copy(tags = t :: tags)
  def put(k: String, v: String): Data575 = copy(meta = meta.updated(k, v))
  def merge(other: Data575): Data575 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data575 {
  given Ordering[Data575] = Ordering.by(_.id)
  def empty: Data575 = Data575(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data575 =
    Data575(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data575] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
