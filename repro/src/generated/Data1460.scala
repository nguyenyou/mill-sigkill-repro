package generated

final case class Data1460(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1460 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1460 = copy(value = value * k)
  def addTag(t: String): Data1460 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1460 = copy(meta = meta.updated(k, v))
  def merge(other: Data1460): Data1460 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1460 {
  given Ordering[Data1460] = Ordering.by(_.id)
  def empty: Data1460 = Data1460(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1460 =
    Data1460(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1460] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
