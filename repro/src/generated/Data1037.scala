package generated

final case class Data1037(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1037 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1037 = copy(value = value * k)
  def addTag(t: String): Data1037 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1037 = copy(meta = meta.updated(k, v))
  def merge(other: Data1037): Data1037 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1037 {
  given Ordering[Data1037] = Ordering.by(_.id)
  def empty: Data1037 = Data1037(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1037 =
    Data1037(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1037] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
