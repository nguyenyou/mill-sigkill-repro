package generated

final case class Data1342(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1342 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1342 = copy(value = value * k)
  def addTag(t: String): Data1342 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1342 = copy(meta = meta.updated(k, v))
  def merge(other: Data1342): Data1342 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1342 {
  given Ordering[Data1342] = Ordering.by(_.id)
  def empty: Data1342 = Data1342(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1342 =
    Data1342(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1342] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
