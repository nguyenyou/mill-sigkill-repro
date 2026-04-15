package generated

final case class Data156(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data156 = copy(name = name.toUpperCase)
  def scale(k: Double): Data156 = copy(value = value * k)
  def addTag(t: String): Data156 = copy(tags = t :: tags)
  def put(k: String, v: String): Data156 = copy(meta = meta.updated(k, v))
  def merge(other: Data156): Data156 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data156 {
  given Ordering[Data156] = Ordering.by(_.id)
  def empty: Data156 = Data156(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data156 =
    Data156(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data156] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
