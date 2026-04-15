package generated

final case class Data1038(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1038 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1038 = copy(value = value * k)
  def addTag(t: String): Data1038 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1038 = copy(meta = meta.updated(k, v))
  def merge(other: Data1038): Data1038 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1038 {
  given Ordering[Data1038] = Ordering.by(_.id)
  def empty: Data1038 = Data1038(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1038 =
    Data1038(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1038] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
