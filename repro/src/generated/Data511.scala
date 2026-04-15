package generated

final case class Data511(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data511 = copy(name = name.toUpperCase)
  def scale(k: Double): Data511 = copy(value = value * k)
  def addTag(t: String): Data511 = copy(tags = t :: tags)
  def put(k: String, v: String): Data511 = copy(meta = meta.updated(k, v))
  def merge(other: Data511): Data511 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data511 {
  given Ordering[Data511] = Ordering.by(_.id)
  def empty: Data511 = Data511(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data511 =
    Data511(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data511] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
